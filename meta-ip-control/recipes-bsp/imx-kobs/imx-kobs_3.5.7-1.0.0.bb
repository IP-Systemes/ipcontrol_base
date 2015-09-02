# Copyright (C) 2013 Freescale Semiconductor

SUMMARY = "Nand boot write source"
DESCRIPTION = "Nand boot write source for IMX BSP"
SECTION = "base"
DEPENDS = "virtual/kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

#SRC_URI = "${FSL_MIRROR}/imx-kobs-${PV}.tar.gz"

#SRC_URI[md5sum] = "1c07f922215d1fe7e202d1ba3dca0293"
#SRC_URI[sha256sum] = "a2854f5dc4c5728fef83a8b68d0e3e0aaba7910557976fc46265a86dc268038a"

SRC_URI = "https://github.com/varigit/var_pkg/raw/master/imx-kobs-3.5.7-1.0.0.tar.gz"

SRC_URI[md5sum] = "bbdcb8e983261e351b4037a8cc04aa7e"
SRC_URI[sha256sum] = "c2b3e4cd9c9d71438d59223f48fbfbbf2e36a5f8029156e597c3894309acf347"

inherit autotools pkgconfig

INCLUDE_DIR="-I${STAGING_INCDIR}  -I${STAGING_KERNEL_DIR}/include/mtd"
EXTRA_OE = "INCLUDE=/"${INCLUDE_DIR}/" all"

COMPATIBLE_MACHINE = "(mx6)"

