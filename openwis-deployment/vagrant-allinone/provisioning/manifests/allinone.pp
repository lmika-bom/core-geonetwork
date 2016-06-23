Package {
	allow_virtual => false,
}

file {["/home/vagrant/bin"]:
    ensure => directory,
    owner  => "vagrant",
    group  => "vagrant",
}

class { openwis::apache_proxy:
}

class { openwis::database:
} ->
class { openwis::portal:
}
