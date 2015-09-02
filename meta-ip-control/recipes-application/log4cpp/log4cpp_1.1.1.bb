LICENSE="GPLv2"
DESCRIPTION = "Log4cpp logging mechanism"

LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"

DEPENDS = "zlib"
DEPENDS_class-native = "zlib-native openssl-native"
DEPENDS_class-nativesdk = "nativesdk-zlib"

SRC_URI = "file://log4cpp-${PV}.tar.gz \
"

SRC_URI[md5]="1e173df8ee97205f412ff84aa93b8fbe"

inherit autotools pkgconfig binconfig

S = "${WORKDIR}/log4cpp"

