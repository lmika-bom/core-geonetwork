class openwis (
    $provisioning_root_dir = "/tmp/provisioning",
    $touchfiles_dir        = "/home/openwis/touchfiles",
    $logs_root_dir         = "/home/openwis/logs",
    $db_server_host_name,
)
{
    $scripts_dir    = "${provisioning_root_dir}/scripts"
    $config_src_dir = "${provisioning_root_dir}/config"
    $working_dir    = "${provisioning_root_dir}/working"
    $downloads_dir  = "${provisioning_root_dir}/downloads"

    $openwis_home   = "/home/openwis"

    #==========================================================================
    # Install common utility packages
    #==========================================================================
    package { [unzip, wget]:
      ensure => latest,
    }

    #==========================================================================
    # Ensure OpenWIS user && group exists
    #==========================================================================
    group { openwis:
        ensure => present
    } ->
    user { openwis:
        ensure => present,
        gid    => "openwis",
        home   => "${$openwis_home}",
        shell  => "/bin/bash"
    }

    #==========================================================================
    # Manage folders & links
    #==========================================================================
    file { ["/home/openwis",
            "${touchfiles_dir}",
            "${logs_root_dir}"]:
        ensure => directory,
        owner => "openwis"
    }

    $dirtree = dirtree("${provisioning_root_dir}")
    ensure_resource(file, $dirtree, {
        ensure => directory
    })

    file { ["${scripts_dir}",
            "${config_src_dir}",
            "${working_dir}",
            "${downloads_dir}"]:
        ensure  => directory,
        require => File["${provisioning_root_dir}"]
    }

    #==============================================================================
    # Configure scripts
    #==============================================================================
    file { "${scripts_dir}/setenv.sh":
        ensure  => file,
        mode    => "0666",
        content => dos2unix(epp("openwis/scripts/setenv.sh", {
            config_src_dir => $config_src_dir,
            working_dir    => $working_dir,
            touchfiles_dir => $touchfiles_dir
        })),
        require => File["${scripts_dir}"]
    } ->
    file { "${scripts_dir}/functions.sh":
        ensure  => file,
        mode    => "0666",
        content => dos2unix(epp("openwis/scripts/functions.sh"))
    }

}
