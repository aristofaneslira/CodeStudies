Matlab I/O Semaphore based on MPI
---------------------------------

Download and extract MatlabMPI using the Makefile:

    make

Then submit the job and watch the output:

    sbatch submit.slurm
    tail -f $(ls -t *.out | head -1)

Example output:

```
Launching MPI rank: 11 on: cn326
Launching MPI rank: 10 on: cn326
Launching MPI rank: 9 on: cn326
Launching MPI rank: 8 on: cn326
Launching MPI rank: 7 on: cn326
Launching MPI rank: 6 on: cn326
Launching MPI rank: 5 on: cn325
Launching MPI rank: 4 on: cn325
Launching MPI rank: 3 on: cn325
Launching MPI rank: 2 on: cn325
Launching MPI rank: 1 on: cn325
Launching MPI rank: 0 on: cn325

unix_launch =

 ssh cn326 -n 'cd /shared/stormcenter/Shen/src/CREST_post-dev/matlab-io-semaphore; /bin/sh ./MatMPI/Unix_Commands.cn326.6.sh  ' 2>>./MatMPI/remote.out &
 /bin/sh ./MatMPI/Unix_Commands.cn325.0.sh &


Rank 10 started I/O.
Rank 11 started I/O.
Rank 1 started I/O.
Rank 1 completed I/O.
Rank 1 started I/O.
Rank 3 started I/O.
Rank 2 completed I/O.
Rank 4 started I/O.
Rank 3 completed I/O.
Rank 5 started I/O.
Rank 10 completed I/O.
Rank 4 completed I/O.
Rank 11 completed I/O.
Rank 6 started I/O.
Rank 5 completed I/O.
Rank 7 started I/O.
Rank 8 started I/O.
Rank 9 started I/O.
Rank 6 completed I/O.
Rank 7 completed I/O.
Rank 8 completed I/O.
Rank 9 completed I/O.
Rank 0 started I/O.
Rank 0 completed I/O.
SUCCESS
>>
```
