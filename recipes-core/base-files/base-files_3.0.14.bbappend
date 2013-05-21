# Set the hostname
DEFAULT_HOSTNAME ?= "openembedded"

hostname = "${DEFAULT_HOSTNAME}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PRINC := "${@int(PRINC) + 1}"
