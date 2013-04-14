DESCRIPTION = "BeagleBoneBlack Factory Tester userspace portion"

LICENSE = "All rights reserved"
LIC_FILES_CHKSUM = "file://autogen.sh;md5=434f985d83d84873d91f4d5ba2490916"

DEPENDS = "libusb1"

SRC_URI = "git://git@github.com/CircuitCo/BeagleBoneBlackTester.git;protocol=ssh \
           file://bbbtester.service"
SRCREV = "db6a05e948ef11ca3fbe58a2c37d9b0d3b2cd0ad"

PV = "0.2"

S = "${WORKDIR}/git"

inherit autotools systemd

do_install_append() {
	install -d ${D}${base_libdir}/systemd/system
	install -m 0644 ${WORKDIR}/bbbtester.service ${D}${base_libdir}/systemd/system
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "bbbtester.service"

RDEPENDS_${PN} = "bash fb-test"
RRECOMMENDS_${PN} += "kernel-devicetree-overlays"
