
DESCRIPTION = "Precompiled U-Boot v2013 provider"
PROVIDES += "u-boot virtual/bootloader"
RPROVIDES_${PN} += "u-boot virtual/bootloader"

LICENSE = "MIT"
MENDER_UBOOT_AUTO_CONFIGURE = "0"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r0"

SRC_URI = " file://U-Boot-2013.01.01.spl \
            file://u-boot.scr"

#This package doesn't have any files for the rootfs in it, option needed to create an empty 
# package so when the rootfs image is made it finds the mksd_xxx.deb package and doesn't complain
FILES_${PN} = ""
ALLOW_EMPTY_${PN} = "1"


# Copy script to the deploy area with u-boot, uImage, and rootfs
do_deploy () {
   install -d ${DEPLOY_DIR_IMAGE}
   install -m 0755 ${WORKDIR}/U-Boot-2013.01.01.spl ${DEPLOY_DIR_IMAGE}
   install -m 0755 ${WORKDIR}/u-boot.scr ${DEPLOY_DIR_IMAGE}
}
addtask deploy after do_install