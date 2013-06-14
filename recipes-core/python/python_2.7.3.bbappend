# enable IPv6 in python.

EXTRA_OECONF_append = "\
  --enable-ipv6=${@base_contains('DISTRO_FEATURES', 'ipv6', 'yes', 'no', d)} \
"
