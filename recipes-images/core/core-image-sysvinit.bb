DESCRIPTION = "A console-only sysvinit image with openssh and procps."

IMAGE_FEATURES += "ssh-server-openssh"
IMAGE_FSTYPES += "ext3"

VIRTUAL-RUNTIME_init_manager = "sysvinit"
TASK_BASIC_SSHDAEMON = ""

IMAGE_INSTALL = "\
    packagegroup-boot \
    packagegroup-basic \
    procps \
    i2c-tools \
    tmux coreutils gateone zsh-full sudo \
    connman connman-tests connman-tools \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

inherit core-image
