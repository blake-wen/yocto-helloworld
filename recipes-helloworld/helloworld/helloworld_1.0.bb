inherit autotools-brokensep linux-kernel-base 

SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "My first recipe Hellow World"
LICENSE="COPYING"
LIC_FILES_CHKSUM = "file://${LICENSE};md5=d32239bcb673463ab874e80d47fae504"

FILESEXTRAPATHS_prepend := "${THISDIR}:"
SRC_URI += "file://files"
S = "${WORKDIR}/files"

#package name
PN = "helloworld"
#package version
PV = "1.0"
#package release
PR = "r0"

python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*  Example recipe Hello World                 *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

addtask display_banner before do_build


do_install_append() {
    install -m 0755 -d ${D}${bindir}/
    install -m 0755 ${S}/helloworld -D ${D}${bindir}/
}
