DESCRIPTION = "An XFCE image for Techworks"

IMAGE_FEATURES += "ssh-server-openssh"

IMAGE_INSTALL = "\
	packagegroup-base \
	packagegroup-base-extended \
	packagegroup-core-boot \
	packagegroup-xfce-base \
	packagegroup-xfce-extended \
	packagegroup-xfce-multimedia \
	packagegroup-fonts-truetype \
	libgnome-keyring \
	ntp tzdata tzdata-americas \
	traceroute tcpdump links netcat-openbsd \
	cronie at sudo \
	${CORE_IMAGE_EXTRA_INSTALL} \
	"

DEFAULT_TIMEZONE="Canada/Saskatchewan"

inherit core-image

