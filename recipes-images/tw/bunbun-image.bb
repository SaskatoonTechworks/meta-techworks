DESCRIPTION = "A console-only sysvinit image that is somewhat stripped down, but still has nano."

IMAGE_FSTYPES += "ext3"
IMAGE_FEATURES += "ssh-server-dropbear"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-base-keyboard \
    packagegroup-machine-base \
    packagegroup-distro-base \
    nano wiringpi tzdata \
    sudo ntp tzdata-americas cronie \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

DEFAULT_TIMEZONE="Canada/Saskatchewan"

inherit core-image

ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "
