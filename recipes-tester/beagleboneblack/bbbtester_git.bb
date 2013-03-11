DESCRIPTION = "BeagleBoneBlack Factory Tester userspace portion"

LICENSE = "All rights reserved"
LIC_FILES_CHKSUM = "file://bbtester.c;md5=ea227677cebb479672f858d88438b686"

SRC_URI = "git://git@github.com/CircuitCo/BeagleBoneBlackTester.git;protocol=ssh"
SRCREV = "0dbad71b26aaac31ec145eb82753a8ac1702e257"

PV = "0.0"

S = "${WORKDIR}/git"

inherit autotools

