FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://ntp.conf \
                   file://ntpdate "

do_install_append() {
    install -d ${D}${sysconfdir}
    install -m 644 ${WORKDIR}/ntp.conf ${D}${sysconfdir}
    install -d ${D}${sysconfdir}/default
    install -m 644 ${WORKDIR}/ntpdate ${D}${sysconfdir}/default
}