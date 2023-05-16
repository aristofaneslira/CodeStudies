%% Limit the number of I/O operations using MatlabMPI
classdef IO_Worker
  properties
    comm
    comm_size
    rank
    message_tag
    locks_max
  end
  methods
    %% Constructor
    function obj = IO_Worker
        MPI_Init;
        global MPI_COMM_WORLD;	% Created by `MPI_Init`.
	obj.comm = MPI_COMM_WORLD;
	obj.rank = MPI_Comm_rank(obj.comm);
	obj.comm_size = MPI_Comm_size(obj.comm);
	obj.message_tag = obj.rank;
	obj.locks_max = 3;
    end

    function lock_acquire(obj)
      %% Forbid rank 0.
      if (obj.rank == 0)
	error('Rank 0 is not allowed to acquire an I/O lock.');
      end

      dest = 0;
      request = 'lock_acquire';
      disp(['Rank ' num2str(obj.rank) ' requested I/O lock.']);
      MPI_Send(dest, obj.message_tag, obj.comm, request);
      [permission] = MPI_Recv(dest, obj.message_tag, obj.comm);
      disp(['Rank ' num2str(obj.rank) ' has I/O lock.']);
     end

    function lock_release(obj)
      %% Forbid rank 0.
      if (obj.rank == 0)
	error('Rank 0 is not allowed to acquire an I/O lock.');
      end

      dest = 0;
      request = 'lock_release';
      MPI_Send(dest, obj.message_tag, obj.comm, request);
      disp(['Rank ' num2str(obj.rank) ' released I/O lock.']);
    end

    %% Blocking function to provide I/O locks to all workers, except
    %% for Rank 0.
    function lock_provide(obj)
      active_locks = 0;
      workers_remaining = ones(obj.comm_size - 1, 1);
      request_lock_queue = [];
      permission = 'granted';
      %% Wait for a message to arrive from each worker.
      while(sum(workers_remaining) > 0)
	%% Check if messages have arrived.
	pause(1);
	[message_ranks message_tags] = MPI_Probe('*', '*', obj.comm);
	if (length(message_ranks) > 0)
	  %% Process the new message(s).
	  source = message_ranks(1);
	  tag = message_tags(1);
	  [request] = MPI_Recv(source, tag, obj.comm);
	  if (request == 'lock_acquire')
	    if (active_locks < obj.locks_max)
	      active_locks = active_locks + 1;
	      MPI_Send(source, source, obj.comm, permission);
	      disp(['Rank ' num2str(source) ' started I/O.' ])
	    else
	      request_lock_queue(end+1) = source;
	    end
	  elseif (request == 'lock_release')
	    active_locks = active_locks - 1;
	    workers_remaining(source) = 0;
	    MPI_Send(source, source, obj.comm, permission);
	    disp(['Rank ' num2str(source) ' completed I/O.' ])
	    if (~isempty(request_lock_queue) && ...
		active_locks < obj.locks_max)
	      active_locks + active_locks + 1;
	      dest = request_lock_queue(1);
	      request_lock_queue = request_lock_queue(2:end);
	      MPI_Send(dest, dest, obj.comm, permission);
	      disp(['Rank ' num2str(source) ' started I/O.' ])
	    end
	  end
	end
      end
    end
  end
end
