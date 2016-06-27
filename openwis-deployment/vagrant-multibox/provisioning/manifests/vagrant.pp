Package {
	allow_virtual => false,
}

$provisioning_root_dir = hiera(openwis::provisioning_root_dir)
$scripts_dir = "${provisioning_root_dir}/scripts"


file {["/home/vagrant/bin"]:
    ensure => directory,
    owner  => "vagrant",
    group  => "vagrant",
} ->
file {"/home/vagrant/bin/deploy-portal":
    ensure => link,
    target => "${scripts_dir}/deploy-portal.sh"
} ->
file {"/home/vagrant/bin/create-db":
    ensure => link,
    target => "${scripts_dir}/create-db.sh"
}

host { "ow4dev-db":
	ensure => present,
	ip     => "192.168.54.101"
}
host { "ow4dev-data":
	ensure => present,
	ip     => "192.168.54.102"
}
host { "ow4dev-portal":
	ensure => present,
	ip     => "192.168.54.103"
}
