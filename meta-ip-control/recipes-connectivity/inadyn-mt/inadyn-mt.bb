MAINTAINER = "Narcis Ilisei"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=3c34afdc3adf82d2448f12715a255122"

SRCDATE = "20100519"
PV = "v.02.18.24+cvs${SRCDATE}"
PR = "r3"

SRC_URI = "cvs://anonymous@inadyn-mt.cvs.sourceforge.net/cvsroot/inadyn-mt;module=${PN};tag=unicows;date=${SRCDATE} \
	file://remove_host_include_paths.patch \
	"

S = "${WORKDIR}/${PN}"

inherit autotools

do_compile() {
	make -f makefile-deprecated
}

do_install() {
	install -d ${D}/usr/bin
	install -m 755 ${S}/bin/linux/inadyn-mt ${D}/usr/bin
}
