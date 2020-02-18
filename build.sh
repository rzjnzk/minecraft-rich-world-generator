#!/bin/sh

(

_main()
{
    cd "${_script_path}"

    javac \
        -target "8" \
        -source "8" \
        -d "./build/classes" \
        -cp "./build/libs/spigot-api-1.15.2-R0.1-20200208.235302-49.jar" \
        ./src/*.java

    _world_dir="./bin/world-previous/$(date --utc +%Y-%m-%d_%H-%M-%S)_utc"

    mkdir -p \
        "./bin/world-previous" \
        "./bin/plugins" \
        "${_world_dir}"

    set +e
    mv -v "./bin/world" "${_world_dir}"
    mv -v "./bin/world_nether" "${_world_dir}"
    mv -v "./bin/world_the_end" "${_world_dir}"
    set -e

    cd "./bin/plugins"
    rm -fv "RichWorldGenerator.jar"
    jar cvf "RichWorldGenerator.jar" \
        -C "../../build/classes" . \
        -C "../../src" "plugin.yml"
    cd "../../"

    printf -- "Running spigot server for manual testing.\n"
    printf -- "Issue the \`stop\` command in the server CLI when manual testing is complete.\n"
    cd ./bin
    java -jar ./spigot*.jar --nogui
}

set -e
_script_name="$(basename "${0}")"
_script_path="$(dirname "${0}")"
_script_path="$(cd "${_script_path}" ; pwd)"
_script_args="$(printf -- "%s\n" "${@}")"
mkdir -p "${_script_path}/${_script_name}-logs"
_main "${@}" | tee --append -- "${_script_path}/${_script_name}-logs/$(date --utc +%Y-%m-%d_%H-%M-%S)_utc.log"

)
