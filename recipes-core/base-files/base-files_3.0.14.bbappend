# Set the hostname
DEFAULT_HOSTNAME ?= "openembedded"

hostname = "${DEFAULT_HOSTNAME}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PRINC := "${@int(PRINC) + 1}"

# remove run, cache, and log from volatiles.
volatiles := '${@oe_filter_out("run|cache|log", "${volatiles}", d)}'

# add /run, needed for systemd
dirs755 =+ "/run"
# re-add cache and log.
dirs755 =+ "${localstatedir}/cache ${localstatedir}/log"
# don't create volatile/{run,log}
dirs755 := '${@oe_filter_out("${localstatedir}/volatile/run|${localstatedir}/volatile/log", "${dirs755}", d)}'

do_install_append() {
	ln -sf /run ${D}${localstatedir}/run
}
