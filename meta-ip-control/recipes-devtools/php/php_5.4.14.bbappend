FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "file://php-${PV}.tar.bz2"

SRC_URI += "file://acinclude-xml2-config.patch \
            file://0001-php-don-t-use-broken-wrapper-for-mkdir.patch"


do_install_append_pn-php() {
	sed -i -e 's#/usr/share/apache2/htdocs#/opt/ipcontrol/web#g' ${D}/${sysconfdir}/apache2/conf.d/php-fpm.conf
	sed -i -e 's#user = nobody#user = webuser#g' ${D}/${sysconfdir}/php-fpm.conf
}
