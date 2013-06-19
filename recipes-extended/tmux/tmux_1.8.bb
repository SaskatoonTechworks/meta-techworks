DESCRIPTION = "Terminal multiplexer"
HOMEPAGE = "http://tmux.sourceforge.net"
SECTION = "console/utils"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://tmux.c;beginline=3;endline=17;md5=8685b4455330a940fab1ff451aa941a0"

DEPENDS = "ncurses libevent sed-native"

SRC_URI = "${SOURCEFORGE_MIRROR}/tmux/${P}.tar.gz"
SRC_URI[md5sum] = "b9477de2fe660244cbc6e6d7e668ea0e"
SRC_URI[sha256sum] = "f265401ca890f8223e09149fcea5abcd6dfe75d597ab106e172b01e9d0c9cd44"

inherit autotools

do_configure_prepend () {
    sed -i -e 's:-I/usr/local/include::' Makefile.am || bb_fatal "sed failed"
}
