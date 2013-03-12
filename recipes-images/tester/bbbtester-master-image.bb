# Image for factory testing

include recipes-images/angstrom/systemd-image.bb

EXTRA_MACHINE_IMAGE_INSTALL ?= ""

IMAGE_INSTALL += " \
        bbbtester \
	usbutils \
	i2c-tools \
	alsa-utils \
	devmem2 \
	iw \
	bonnie++ \
	hdparm \
	iozone3 \
	iperf \
	lmbench \
	rt-tests \
	evtest \
	bc \
	kernel-modules \
	${EXTRA_MACHINE_IMAGE_INSTALL} \
"

export IMAGE_BASENAME = "BBB-tester-master-image"
