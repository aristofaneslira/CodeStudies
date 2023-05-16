%% Demonstrate MPI based I/O locks.
%%
%% `io_semaphore` is called directly by the `MPI_Run` function.
%%
function io_semaphore
  io_worker = IO_Worker;
  %% Have the root worker allow all other workers to perform their MPI
  %% operations, and then have the root worker run the MPI operation.
  if (io_worker.rank == 0)
    io_worker.lock_provide;
    disp(['Rank ' num2str(io_worker.rank) ' started I/O.'])
    pause(io_worker.rank)
    disp(['Rank ' num2str(io_worker.rank) ' completed I/O.'])
  else
    io_worker.lock_acquire;
    disp(['Rank ' num2str(io_worker.rank) ' started operation.'])
    pause(io_worker.rank)
    disp(['Rank ' num2str(io_worker.rank) ' completed operation.'])
    io_worker.lock_release;
  end

  %% Completion message.
  disp('SUCCESS');
  MPI_Finalize;
end
