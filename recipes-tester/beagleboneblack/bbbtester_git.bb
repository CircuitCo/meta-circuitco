DESCRIPTION = "BeagleBoneBlack Factory Tester userspace portion"

LICENSE = "All rights reserved"
LIC_FILES_CHKSUM = "file://autogen.sh;md5=434f985d83d84873d91f4d5ba2490916"

SRC_URI = "git://git@github.com/CircuitCo/BeagleBoneBlackTester.git;protocol=ssh"
SRCREV = "971bcb722e063c1372958a653b9eb6e2ef380da7"

PV = "0.0.1"

S = "${WORKDIR}/git"

inherit autotools

RDEPENDS_${PN} = "bash"
RRECOMMENDS_${PN} += "kernel-devicetree-overlays"
