Package {
	allow_virtual => false,
}

class { openwis::apache_proxy:
}

class { openwis::database:
} ->

/*
class { openwis::dataservice:
} ->
*/

class { openwis::portal:
}
