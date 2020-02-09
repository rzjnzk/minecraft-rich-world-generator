#!/bin/sh

(

_main()
{
    javac \
        -target 8 \
        -source 8 \
        -d ./build/classes \
        -cp ./build/libs/spigot-api-1.15.2-R0.1-20200208.235302-49.jar \
        ./src/RichWorldGenerator.java

    cd ./bin
    jar cvf RichWorldGenerator.jar \
        -C ../build/classes . \
        -C ../src plugin.yml
    cd ..
}

set -e
_script_name="$(basename "${0}")"
_script_path="$(dirname "${0}")"
_script_path="$(cd "${_script_path}" ; pwd)"
_script_args="$(printf -- "%s\n" "${@}")"
mkdir "${_script_path}/${_script_name}-logs"
_main "${@}" | tee --append -- "${_script_path}/${_script_name}-logs/$(date --utc +%Y-%m-%d_%H-%M-%S).log"

)
