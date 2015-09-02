#
#Variscite Firmware
#
SRC_URI += "https://github.com/varigit/BT_VAR_FW/archive/master.zip"
SRC_URI[md5sum] = "d5a30bd6c79a7a40de4467d3c79a5dfb"
SRC_URI[sha256sum] = "b33b9ff92cd164a7870f12f62247c224ad2882c370efce0e502e67cc93bb5b50"


do_install_append() {
    #add Variscite Firmware
	cp -r ../BT_VAR_FW-master/* ${D}/lib/firmware/ti-connectivity
	
	# fixup wl12xx location, after 2.6.37 the kernel searches a different location for it
	( cd ${D}/lib/firmware ; ln -snf ti-connectivity/* . )
}

