DESCRIPTION = "A console-only systemd image with more full-featured Linux system \
functionality installed."

IMAGE_FEATURES += "ssh-server-openssh"
IMAGE_FSTYPES += "ext3"

VIRTUAL-RUNTIME_init_manager = "systemd"
TASK_BASIC_SSHDAEMON = ""

IMAGE_INSTALL = "\
    packagegroup-boot \
    packagegroup-base-extended \
    packagegroup-basic \
    procps \
    i2c-tools \
    tmux coreutils gateone zsh-full sudo \
    connman connman-tests connman-tools \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

inherit core-image
