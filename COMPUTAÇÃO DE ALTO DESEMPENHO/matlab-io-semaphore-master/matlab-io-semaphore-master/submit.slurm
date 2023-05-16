#!/bin/bash -x
#SBATCH -N 2
#SBATCH -p general
#SBATCH --ntasks-per-node=6

#-----------------------------------------------------------------------
# Create variables for MatlabMPI `MPI_Run` function.
#-----------------------------------------------------------------------

# Format node names as a MATLAB cell array, e.g. {'cn04','cn05'}.  NB:
# `hostlist` is a program from the python-hostlist PIP package.
#
nodelist=\{\'$(/apps2/python/3.4.3-gcc/bin/hostlist -s "','" -e $SLURM_JOB_NODELIST)\'\}

# Get the total number of SLURM CPUs.
#
# Normally SLURM_JOB_CPUS_PER_NODE is formatted as "6(x3),5" which one
# has to parse to get the total CPU count.
function expand_slurm_job_cpus_per_node () {
    local cpus
    cpus=( $(echo "${SLURM_JOB_CPUS_PER_NODE}" | tr ',' ' ') )
    local num count
    for val in ${cpus[*]}; do
	num="${val/(*)/}"
	if [[ -z "${val%%*)}" ]]; then
	    count=$(echo $val | sed -E 's#[0-9]+\(x([0-9]+)\)#\1#')
	else
	    count=1
	fi
	printf "$num%.0s " $(seq $count)
    done
}
function slurm_ncpus () {
    echo $(( $(expand_slurm_job_cpus_per_node | tr ' ' '+') 0 ))
}
ncpus=$(slurm_ncpus)

#-----------------------------------------------------------------------

# Run a single copy of MatlabMPI using `MPI_Run` function, which
# starts MATLAB on each CPU.  `MatMPI_Delete_all` clears output files
# and logs in the MatMPI/ directory.
#
matlab \
       -nodisplay \
       -nojvm \
       -singleCompThread \
       -r "MatMPI_Delete_all; eval( MPI_Run('io_semaphore', $ncpus, $nodelist) );"
