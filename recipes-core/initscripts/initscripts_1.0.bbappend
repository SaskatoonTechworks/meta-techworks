# remove log from volatiles/00_core. This should be persistent.
do_configure_append() {
    [ -f "${WORKDIR}/volatiles" ] && sed -i.bk -e '\/var\/volatile\/log/d' -e '\/var\/log\/wtmp/d' ${WORKDIR}/volatiles
}
