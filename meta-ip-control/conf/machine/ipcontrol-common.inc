#@TYPE: Machine
#@NAME: i.MX6Solo Varisicte MX6 SOM
#@DESCRIPTION: Machine configuration for Variscoite MX6Q SOM
#Varisicte VAR SOM MX6 common definitions for all Som's
#
#
include conf/machine/include/imx-ipcontrol-base.inc
include conf/machine/include/tune-cortexa9.inc

#
#variscite U-Boot
#
PREFERRED_PROVIDER_u-boot = "u-boot-variscite"
#
PREFERRED_PROVIDER_virtual/kernel = "linux-variscite"


#
#Set file system for 4GB not 1.
# This create the size of the SD-Card rootfs file system
IMAGE_ROOTFS_SIZE = "3600000"
#
SERIAL_CONSOLE = "115200 ttymxc0"

#Wifi/Bluetooth firmwre
MACHINE_EXTRA_RRECOMMENDS += "linux-firmware-wl12xx"

MACHINE_FEATURES += " pci wifi bluetooth"

#
# UBIFS for Variscite NAND 0.5 GB
#
IMAGE_FSTYPES += " ubi "
UBI_ROOT_FS_NAME = "[rootfs]"
UBI_VOLNAME  = "rootfs"
#MKUBIFS_ARGS = " -m 2048 -e 126976 -c 3950 "
MKUBIFS_ARGS = " -m 2048 -e 124KiB -c 3965 "
UBINIZE_ARGS = " -m 2048 -p 128KiB -s 2048 -O 2048 "

PREFERRED_PROVIDER_jpeg = "jpeg"
PREFERRED_PROVIDER_java2-runtime = "openjdk-7-jre"
PREFERRED_PROVIDER_java2-vm = "openjdk-7-jre"
PREFERRED_PROVIDER_jpeg-native = "jpeg-native"

PREFERRED_PROVIDER_virtual/java-initial = "cacao-initial"
PREFERRED_PROVIDER_virtual/java-native = "jamvm-native"
PREFERRED_PROVIDER_virtual/javac-native = "ecj-bootstrap-native"


PREFERRED_VERSION_openjdk-7-jre = "25b30-2.3.12"
PREFERRED_VERSION_icedtea7-native = "2.1.3"



