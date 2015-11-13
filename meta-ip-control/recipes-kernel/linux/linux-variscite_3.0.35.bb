# Adapted from linux-imx.inc, copyright (C) 2013 O.S. Systems Software LTDA
# Copyright (C) 2014 Thomas Deruyter
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc

DESCRIPTION = "Linux kernel for Variscite boards"

SRC_URI = "git://github.com/varigit/linux-2.6-imx.git \
           file://defconfig \
"

LOCALVERSION = "-ES-2"
SRCREV = "5d7e2a68a196ae89a0ede7bebf3e58f4cfb2ebe0"


# Huawei MU609 Support Patch
SRC_URI += "file://0001-Remove-GPIO5-20-button.patch \
			file://0002-MU609-huawei.patch \
			file://0003-Add_MicroSD_RTC.patch \
			file://0004-Add_SPI_MAX1113x.patch \
			file://0005-MU509_UART5.patch \
			file://0006-MU509-Device.patch \ 
			file://0007-Nand_MTD_Struct.patch \ 
"


COMPATIBLE_MACHINE = "(mx6)"
