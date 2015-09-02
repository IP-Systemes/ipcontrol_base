FILESEXTRAPATHS_prepend := "${THISDIR}/connman-conf:"

SRC_URI_append_ipcontrol = "file://settings "

do_install_append() {
    if test -e ${WORKDIR}/settings ; then
        install -d ${D}${localstatedir}/lib/connman
        install -m 0644 ${WORKDIR}/settings ${D}${localstatedir}/lib/connman
    fi
}
