DESCRIPTION = "Image with terminal, editor, and file manager."

IMAGE_FEATURES += "package-management ssh-server-dropbear hwcodecs"

LICENSE = "MIT"

inherit core-image


DISTRO_FEATURES += "pulseaudio"
DISTRO_TYPE += "debug"

SOC_EXTRA_IMAGE_FEATURES ?= ""

# Add extra image features
EXTRA_IMAGE_FEATURES += " \
    ${SOC_EXTRA_IMAGE_FEATURES} \
    nfs-server \
"

SOC_IMAGE_INSTALL = ""

ROOTFS_POSTPROCESS_COMMAND += "ssh_allow_root;" 
ROOTFS_POSTPROCESS_COMMAND += "postinst_enable_logging;"

IMAGE_INSTALL += " \
    ${SOC_IMAGE_INSTALL} \
    cpufrequtils \
    nano \
    cronie \
    minicom \
    iptables \
    php php-cli php-cgi php-fpm php-fpm-apache2 php-pear php-dev \
    imx-kobs \
    tcf-agent \
    inetutils \
    inetutils-ftp \
    openssh-sftp-server \
    canutils \
    ethtool \
    i2c-tools \
    curl \
    strace \
    gnokii \
    flashrom \
    proftpd \
    ntp ntpdate \
    libmodbus \
    testmodbus \
    ipsec-tools \
    openvpn \
    log4cpp \
    mtd-utils \
    mtd-utils-ubifs \
    apache2 \
    ppp ppp-oe ppp-tools \
    ppp-dialin \
    quota \
    watchdog \
    sudo \
    tcpdump \
    tzdata \
    lua5.1 \
    openjdk-7-jre openjdk-7-vm-jamvm openjdk-7-vm-cacao \
    strace dropbear binutils \
    classpath \
    classpath-common \
    classpath-examples \
    classpath-tools \
    jamvm \
    cacao \
   "

export IMAGE_BASENAME = "ipc-image-base"



# allow dropbear/openssh to accept root logins and logins from accounts with an empty password string
ssh_allow_root () {
	if [ -e ${IMAGE_ROOTFS}${sysconfdir}/ssh/sshd_config ]; then
		sed -i 's#.*PermitRootLogin.*#PermitRootLogin yes#' ${IMAGE_ROOTFS}${sysconfdir}/ssh/sshd_config
	fi

	if [ -e ${IMAGE_ROOTFS}${sbindir}/dropbear ] ; then
		if grep -q DROPBEAR_EXTRA_ARGS ${IMAGE_ROOTFS}${sysconfdir}/default/dropbear 2>/dev/null ; then
			if ! grep -q "DROPBEAR_EXTRA_ARGS=.*-B" ${IMAGE_ROOTFS}${sysconfdir}/default/dropbear ; then
				sed -i 's/^DROPBEAR_EXTRA_ARGS="*\([^"]*\)"*/DROPBEAR_EXTRA_ARGS="\1 -B"/' ${IMAGE_ROOTFS}${sysconfdir}/default/dropbear
			fi
		else
			printf '\nDROPBEAR_EXTRA_ARGS="-B"\n' >> ${IMAGE_ROOTFS}${sysconfdir}/default/dropbear
		fi
	fi
}

EXPORT_FUNCTIONS ssh_allow_root
