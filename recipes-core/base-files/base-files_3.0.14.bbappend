# Set the hostname
DEFAULT_HOSTNAME ?= "openembedded"

hostname = "${DEFAULT_HOSTNAME}"

#FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PRINC := "${@int(PRINC) + 1}"

# remove log from volatiles.
volatiles := '${@oe_filter_out("log", "${volatiles}", d)}'
#volatiles = "tmp"

# re-add log.
dirs755 += "${localstatedir}/log"
# don't create volatile/log
dirs755 := '${@oe_filter_out("${localstatedir}/volatile/log", "${dirs755}", d)}'

do_install_append() {
	touch ${D}${localstatedir}/log/wtmp
}
