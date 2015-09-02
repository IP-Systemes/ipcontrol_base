require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4c6cde5df68eff615d36789dc18edd3b"
COMPATIBLE_MACHINE = "(ipcontrol|mx6s)"

PROVIDES = "u-boot"

PV = "v2009.08-yocto+4.1.0"

#SRCREV = "8dc72162f9baf0560fcbe83b9abdfa827c9b20eb"
SRCREV = "1898d5ae6dda9d06b46306c1bbf1030b8ca444f3"

SRC_URI = "git://github.com/varigit/uboot-imx.git"

S = "${WORKDIR}/git"

UBOOT_SUFFIX = "bin"
UBOOT_PADDING = "2"
UBOOT_MAKE_TARGET = "u-boot.bin"

PACKAGE_ARCH = "${MACHINE_ARCH}"
EXTRA_OEMAKE += 'HOSTSTRIP=true'

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_compile_prepend() {
	if [ "${@base_contains('DISTRO_FEATURES', 'ld-is-gold', 'ld-is-gold', '', d)}" = "ld-is-gold" ] ; then
		sed -i 's/$(CROSS_COMPILE)ld/$(CROSS_COMPILE)ld.bfd/g' config.mk
	fi
}

