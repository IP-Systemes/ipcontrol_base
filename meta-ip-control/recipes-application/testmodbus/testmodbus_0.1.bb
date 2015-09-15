DESCRIPTION = "The ModBus library demo application."
SECTION = "base"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYRIGHT;md5=e247c465dd2c6b0e3b558154c500a92a"
PR = "r1"

DEPENDS = "libmodbus"
RDEPENDS_${PN} = "initscripts libmodbus"

inherit pkgconfig

SRC_URI = "file://bandwidth-client.c \
           file://bandwidth-server-many-up.c \
           file://bandwidth-server-one.c \
           file://random-test-client.c \
           file://random-test-server.c \
           file://unit-test-client.c \
           file://unit-test-server.c \
           file://unit-test.h \
           file://modbus*.h \
           file://version.c \
           file://COPYRIGHT \
           "


do_compile () {
    ${CC} -Wall -I ${WORKDIR} -c ${WORKDIR}/unit-test-server.c -o ${WORKDIR}/unit-test-server.o
    ${CC} -o ${WORKDIR}/unit-test-server ${WORKDIR}/unit-test-server.o -lmodbus
    
    ${CC} -Wall -I ${WORKDIR} -c ${WORKDIR}/unit-test-client.c -o ${WORKDIR}/unit-test-client.o
    ${CC} -o ${WORKDIR}/unit-test-client ${WORKDIR}/unit-test-client.o -lmodbus
    
    #${CC} -Wall -I ${WORKDIR} -c ${WORKDIR}/version.c -o ${WORKDIR}/version.o
    #${CC} -o ${WORKDIR}/version ${WORKDIR}/version.o -lmodbus
    
}

do_install () {
	install -d ${D}${sysconfdir}/init.d

    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/unit-test-server ${D}${sbindir}/
    install -m 0755 ${WORKDIR}/unit-test-client ${D}${sbindir}/
}

BBCLASSEXTEND = "native"