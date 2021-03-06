# This recipe is intended as a 'simpler' replacement for packagegroup-base.
# Please communicate your use cases and suggestions to the mailinglist(s)

DESCRIPTION = "Basic task to get a Techworks device online"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PR = "r0"

inherit packagegroup

# packages which content depend on MACHINE_FEATURES need to be MACHINE_ARCH
#
PACKAGE_ARCH = "${MACHINE_ARCH}"

# Poke extra recomendations into the list using your machine.conf
#
MACHINE_EXTRA_RRECOMMENDS ?= ""
MACHINE_EXTRA_RDEPENDS ?= ""

RPROVIDES_${PN} += "task-basic"
RREPLACES_${PN} += "task-basic"
RCONFLICTS_${PN} += "task-basic"
#
# The section below is designed to match with packagegroup-boot, but doesn't depend on it to allow for more freedom 
# when writing image recipes.
# It also avoids the choice between connman/networkmanager/ifupdown since that is an image feature, not a
# distro feature.
#
# Util-linux (u)mount is included because the busybox one can't handle /etc/mtab being symlinked to /proc/mounts
#
RDEPENDS_${PN} = "\
    ${MACHINE_EXTRA_RDEPENDS} \
"

#
# The following section is split in 3:
#   1) Machine features: kernel modules and userspace helpers for those
#   2) Distro features: packages associated with those
#   3) Nice to have: packages that are nice to have, but aren't strictly needed  
#
RRECOMMENDS_${PN} = "\
    ${MACHINE_EXTRA_RRECOMMENDS} \
    ${@base_contains("MACHINE_FEATURES", "usbhost", "usbutils", "", d)} \
    ${@base_contains("MACHINE_FEATURES", "alsa", "alsa-utils-alsamixer", "", d)} \
    ${@base_contains("MACHINE_FEATURES", "usbgadget", "kernel-module-g-ether kernel-module-g-serial kernel-module-g-mass-storage kernel-module-g-multi", "", d)} \
    \
    ${@base_contains("DISTRO_FEATURES", "bluetooth", "bluez4", "", d)} \
    ${@base_contains("DISTRO_FEATURES", "wifi", "iw wpa-supplicant", "", d)} \
    tzdata \
    cpufrequtils \
    htop \
"
