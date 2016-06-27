Package {
	allow_virtual => false,
}

class { openwis::apache_proxy:
}

class { openwis::portal:
}
