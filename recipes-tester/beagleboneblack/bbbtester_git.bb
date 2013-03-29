DESCRIPTION = "BeagleBoneBlack Factory Tester userspace portion"

LICENSE = "All rights reserved"
LIC_FILES_CHKSUM = "file://autogen.sh;md5=434f985d83d84873d91f4d5ba2490916"

DEPENDS = "libusb1"

SRC_URI = "git://git@github.com/CircuitCo/BeagleBoneBlackTester.git;protocol=ssh \
           file://bbbtester.service"
SRCREV = "351d6fff554a5d1e1d79991b3160b68c8f5527f0"

PV = "0.0.1"

S = "${WORKDIR}/git"

inherit autotools systemd

do_configure_prepend() {
	sed -i -e s:-Werror::g Makefile.am
}

do_install_append() {
	install -d ${D}${base_libdir}/systemd/system
	install -m 0644 ${WORKDIR}/bbbtester.service ${D}${base_libdir}/systemd/system
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "bbbtester.service"

RDEPENDS_${PN} = "bash"
RRECOMMENDS_${PN} += "kernel-devicetree-overlays"
