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
	ntpdate \	
	ntpdate-systemd \
	util-linux-fdisk \
	dosfstools \
	parted \
"

export IMAGE_BASENAME = "BBB-tester-master-image"

add_tester_fstab() {
	install -d ${IMAGE_ROOTFS}/media/testerlogs
	echo "/dev/mmcblk0p3       /media/testerlogs    vfat       defaults              0  0" >> ${IMAGE_ROOTFS}${sysconfdir}/fstab
}

ROOTFS_POSTPROCESS_COMMAND += "add_tester_fstab ; "
