SOC_FAMILY = "socfpga"

require conf/machine/include/arm/armv7a/tune-cortexa9.inc

# Increase this everytime you change something in the kernel
MACHINE_KERNEL_PR = "r1"

# UBOOT_ENTRYPOINT = "0x80008000"
# UBOOT_LOADADDRESS = "0x80008000"

KERNEL_IMAGETYPE ?= "zImage"
MACHINE_EXTRA_RRECOMMENDS = " kernel-modules"
MACHINE_FEATURES = "kernel26"

# file system images required
IMAGE_FSTYPES ?= "cpio ext3 tar.gz jffs2"

# u-boot setup
# UBOOT_SUFFIX ?= "sfp"
# UBOOT_BINARY ?= "u-boot-with-spl.${UBOOT_SUFFIX}"

do_image_wic[depends] += "mtools-native:do_populate_sysroot dosfstools-native:do_populate_sysroot virtual/bootloader:do_deploy virtual/kernel:do_deploy"


