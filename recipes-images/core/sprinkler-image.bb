DESCRIPTION = "A console-only image for my sprinkler system"

IMAGE_FEATURES += "ssh-server-openssh package-management"
IMAGE_FEATURES += "dev-pkgs tools-sdk"

# Installs the tools to make this board work
# and make my programs for it work. Also
# install the beaglebone webpage.

IMAGE_INSTALL = "\
    packagegroup-techworks-boot \
    packagegroup-techworks-basic \
    ${CORE_IMAGE_EXTRA_INSTALL}"

# Special packages for me!!
# Use whatever init manager the distro uses...
IMAGE_INSTALL += "\
    ${VIRTUAL-RUNTIME_dev_manager} \
    ${VIRTUAL-RUNTIME_login_manager} \
    ${VIRTUAL-RUNTIME_init_manager} \
    ${VIRTUAL-RUNTIME_initscripts}"

# zsh-full is a replacement for zsh that
# installs the full featured version, not
# the stripped down one from meta-oe.
IMAGE_INSTALL += "zsh-full"

# Nice things to have:
# * procps because busybox's ps sucks
# * tzdata-americas because America/Regina isn't in the default one
# * ntp because the beaglebone doesn't have an RTC
# * i2c-tools because it's nice to debug that stuff
# * coreutils because most of busybox's small tools are not awesome.
# * tmux because I like it more than screen
# * gateone is a handy HTML5 ssh client
# * sudo is nice for setting up GPIO files and such
# * git is needed for updating my code on the fly
IMAGE_INSTALL += "\
    procps tzdata-americas ntp ntpdate \
    i2c-tools tmux coreutils gateone \
    sudo git cronie"

# connman is used instead of ifupdown, thinking
# of removing this because dbus sucks on small
# images. It is useful for avahi and connman.
IMAGE_INSTALL += "connman connman-tests connman-tools"

IMAGE_INSTALL_append_beaglebone += " beaglebone-getting-started"

inherit core-image
