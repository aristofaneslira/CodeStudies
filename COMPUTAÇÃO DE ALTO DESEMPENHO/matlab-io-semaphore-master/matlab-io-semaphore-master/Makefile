# Unpack MatlabMPI in current directory and add to MATLAB path using
# `startup.m` file.

#URL = https://www.ll.mit.edu/mission/cybersec/softwaretools/matlabmpi/MatlabMPI_v1.2.tar.gz
#URL = https://www.ll.mit.edu/mission/cybersec/softwaretools/matlabmpi/MatlabMPI_v0.95.tar.gz
URL = https://www.ll.mit.edu/mission/cybersec/softwaretools/pmatlab/pMatlab-v2.0.15.tgz
TARBALL = $(lastword $(subst /, ,$(URL)))

startup.m : MatlabMPI/src
	echo "addpath('$(abspath $<)');" >> $@

MatlabMPI/src : $(TARBALL)
	tar -xvpf $< $(basename $<)/MatlabMPI --strip-components=1
	touch -r $@ $<

$(TARBALL) :
	wget $(URL)
