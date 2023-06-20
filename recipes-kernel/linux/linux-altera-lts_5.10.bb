LINUX_VERSION = "5.10.50"
LINUX_VERSION_SUFFIX = "-lts"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SRCREV = "1807da3569b8e03a60967b5906be0eb834611c71"

include linux-altera.inc

SRC_URI:append:de1-soc = " file://0001-socfpga_cyclone5_socdk_dts.patch "
