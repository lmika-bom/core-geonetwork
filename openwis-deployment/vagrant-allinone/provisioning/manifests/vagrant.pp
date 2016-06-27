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
