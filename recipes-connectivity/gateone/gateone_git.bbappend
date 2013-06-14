# Add init script for gateone.

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = "file://gateone-init"

inherit update-rc.d

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/gateone-init ${D}${sysconfdir}/init.d/gateone
}

INITSCRIPT_NAME = "gateone"
