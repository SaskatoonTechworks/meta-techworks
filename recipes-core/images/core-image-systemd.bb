DESCRIPTION = "A console-only systemd image with more full-featured Linux system \
functionality installed."

IMAGE_FEATURES += "ssh-server-openssh"
IMAGE_FSTYPES += "ext3"

VIRTUAL-RUNTIME_init_manager = "systemd"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-basic \
    gadget-init \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

inherit core-image
