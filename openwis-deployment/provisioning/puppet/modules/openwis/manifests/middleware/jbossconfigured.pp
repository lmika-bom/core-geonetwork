class openwis::middleware::jbossconfigured (
) {
    include openwis::middleware::jboss

    # ----------------------------------------------------------------
    # Ensure that the Jboss CLI command is available
    # ----------------------------------------------------------------
    file { "${openwis::middleware::jboss::jboss_home}/bin/jboss-cli.sh":
        ensure => present,
        mode => '0755'
    }

    #exec { 'configure-jboss-using-cli':
    #    command => "jboss-cli --connect -c '${command}'",
    #    path => "${openwis::middleware::jboss::jboss_home}/bin"
    #}
}