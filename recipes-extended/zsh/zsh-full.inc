DESCRIPTION = "UNIX Shell similar to the Korn shell"
HOMEPAGE="http://www.zsh.org"
SECTION = "base/shell"

PR = "r0"

LICENSE = "ZSH"
LIC_FILES_CHKSUM = "file://LICENCE;md5=ad234d4b46db63491c4a9789da4fb341"

DEPENDS = "ncurses bison-native"
RCONFLICTS_${PN} = "zsh"
RREPLACES_${PN} = "zsh"
RPROVIDES_${PN} = "zsh"

SRC_URI = "http://downloads.sourceforge.net/project/zsh/zsh/${PV}/zsh-${PV}.tar.gz"
S = "${WORKDIR}/zsh-${PV}"

inherit autotools gettext update-alternatives

EXTRA_OECONF = " \
    --bindir=${base_bindir} \
    --enable-etcdir=${sysconfdir} \
    --enable-fndir=${datadir}/${PN}/${PV}/functions \
    --enable-site-fndir=${datadir}/${PN}/site-functions \
    --with-term-lib='ncursesw ncurses' \
    --with-tcsetpgrp \
    --enable-cap \
    --enable-multibyte \
    --disable-gdbm \
    zsh_cv_shared_environ=yes \
"

ALTERNATIVE_${PN} = "sh"
ALTERNATIVE_LINK_NAME[sh] = "${base_bindir}/sh"
ALTERNATIVE_TARGET[sh] = "${base_bindir}/zsh"
ALTERNATIVE_PRIORITY = "100"

export AUTOHEADER = "true"

do_configure () {
    gnu-configize --force
    oe_runconf
}

pkg_postinst_${PN} () {
    touch $D${sysconfdir}/shells
    grep -q "bin/zsh" $D${sysconfdir}/shells || echo /bin/zsh >> $D${sysconfdir}/shells
}

FILES_${PN}-dbg += "\
    ${libdir}/zsh/.debug/*.so \
    ${libdir}/zsh/${PV}/zsh/.debug/*.so \
    ${libdir}/zsh/${PV}/zsh/db/.debug/*.so \
    ${libdir}/zsh/${PV}/zsh/net/.debug/*.so \
"

FILES_${PN} += "\
    ${libdir}/zsh/*.so \
    ${libdir}/zsh/${PV}/zsh/*.so \
    ${libdir}/zsh/${PV}/zsh/db/*.so \
    ${libdir}/zsh/${PV}/zsh/net/*.so \
    ${datadir}/zsh/${PV}/scripts/newuser \
"
