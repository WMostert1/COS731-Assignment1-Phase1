// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.

export const environment = {
    production: false,

    region: 'eu-west-1',

    identityPoolId: 'eu-west-1:0cfa66c4-8e9b-4d06-8b5a-83265f958860',
    userPoolId: 'eu-west-1_RIJ81KRTF',
    clientId: '4duj0oi1htm01jds5i407l5sgd',


    bucketRegion: 'eu-west-1',

    cognito_identity_endpoint: '',
    sts_endpoint: ''
};

