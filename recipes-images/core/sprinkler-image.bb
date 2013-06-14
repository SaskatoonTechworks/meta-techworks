DESCRIPTION = "A console-only image for my sprinkler system"

IMAGE_FEATURES += "ssh-server-openssh"
#IMAGE_FSTYPES += "ext3"

VIRTUAL-RUNTIME_init_manager = "sysvinit"
TASK_BASIC_SSHDAEMON = ""

# Installs the tools to make this board work
# and make my programs for it work. Also
# install the beaglebone webpage.

# connman is used instead of ifupdown
# zsh-full is a replacement for zsh that
# installs the full featured version, not
# the stripped down one from meta-oe.

IMAGE_INSTALL = "\
    packagegroup-boot \
    packagegroup-basic \
    procps tzdata-americas ntp nodejs bonescript \
    i2c-tools beaglebone-getting-started ntpdate \
    tmux coreutils gateone zsh-full sudo nodejs4 \
    connman connman-tests connman-tools \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

inherit core-image
