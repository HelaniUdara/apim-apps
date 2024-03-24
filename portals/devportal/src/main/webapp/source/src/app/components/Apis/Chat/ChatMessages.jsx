/*
 * Copyright (c) 2024, WSO2 LLC. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import React, { useRef, useEffect } from 'react';
import { PropTypes } from 'prop-types';
import { Box, Typography } from '@mui/material';
import { FormattedMessage } from 'react-intl';
import { useSettingsContext } from 'AppComponents/Shared/SettingsContext';
import LaunchIcon from '@mui/icons-material/Launch';
import Alert from '@mui/material/Alert';
import { Link } from 'react-router-dom';
import ChatIcon from '@mui/icons-material/Chat';
import ChatInput from './ChatInput';
import ChatMessage from './ChatMessage';
import Loader from './Loader';

/**
 * Renders Chat Messages view.
 *
 * @param {JSON} props Parent pros.
 * @returns {JSX} renders Chat Messages view.
 */
function ChatMessages(props) {
    const {
        messages, loading, onSend, user,
    } = props;

    const { settings: { aiAuthTokenProvided } } = useSettingsContext();
    const messagesEndRef = useRef(null);

    const subjectLine = 'AI Assistant can make mistakes. Consider checking important information.';

    const style = {
        width: '30px',
        height: '30px',
        backgroundColor: '#567189',
        alignItems: 'center',
        justifyContent: 'center',
        display: 'flex',
        margin: '10px 10px 10px 0px',
        borderRadius: '50% 50% 50% 0',
    };

    const scrollToBottom = () => {
        messagesEndRef.current?.scrollIntoView({ behavior: 'smooth' });
    };

    useEffect(scrollToBottom, [messages]);

    const authTokenNotProvidedWarning = (
        <FormattedMessage
            id='Apis.Details.ApiChat.warning.authTokenMissing'
            defaultMessage={'You must provide a token to start using the AI search assistant. To obtain one, '
                + 'follow the steps provided under {marketplaceAssistantDocLink} '}
            values={{
                marketplaceAssistantDocLink: (
                    <Link
                        onClick={() => {
                            window.location.href = 'https://apim.docs.wso2.com/en/latest/get-started/overview/';
                        }}
                    >
                        Search APIs with Marketplace Assistant
                        <LaunchIcon
                            style={{ marginLeft: '2px' }}
                            fontSize='small'
                        />
                    </Link>
                ),
            }}
        />
    );

    return (
        <Box
            maxHeight='100%'
            display='flex'
            flexDirection='column'
            marginLeft='5%'
        >
            <Box
                display='flex'
                justifyContent='center'
                overflow='auto'
            >
                <Box
                    maxWidth='1320px'
                    width='100%'
                >
                    {aiAuthTokenProvided ? (
                        messages.map((message) => (
                            <Box my={1}>
                                <ChatMessage message={message} user={user} />
                            </Box>
                        ))
                    ) : (
                        <Box display='flex' justifyContent='center' alignItems='center' mr='5%' mb={1}>
                            <Alert severity='warning'>
                                {authTokenNotProvidedWarning}
                            </Alert>
                        </Box>
                    )}

                    {loading && (
                        <Box
                            display='flex'
                            flexDirection='column'
                            alignItems='flex-start'
                        >
                            <Box display='flex' alignItems='center'>
                                <div style={style}>
                                    <ChatIcon style={{ fill: '#fff', stroke: '#fff', fontSize: 'small' }} />
                                </div>
                                <Typography variant='body1' style={{ fontWeight: '500', fontSize: '12pt' }}>Assistant</Typography>
                            </Box>
                            <Box
                                textAlign='left'
                                bgcolor='#fff'
                                borderRadius='10px'
                                justifyContent='flex-start'
                                px={3}
                                marginLeft='12px'
                                marginBottom='10px'
                            >
                                <Loader />
                            </Box>
                        </Box>
                    )}
                    <div ref={messagesEndRef} />
                </Box>
            </Box>

            <Box
                display='flex'
                justifyContent='center'
            >
                <Box
                    mt={1.5}
                    mb={0.5}
                    width='100%'
                    maxWidth='1380px'
                    marginRight='5%'
                >
                    <ChatInput onSend={onSend} />
                </Box>

            </Box>
            <Box mb={1}>
                <Typography
                    color='grey'
                    variant='body2'
                    fontSize='8pt'
                    textAlign='center'
                    lineHeight='1.4'
                    marginRight='5%'
                >
                    {subjectLine}
                </Typography>
            </Box>
        </Box>
    );
}

ChatMessages.propTypes = {
    messages: PropTypes.instanceOf(Array).isRequired,
    loading: PropTypes.bool.isRequired,
    onSend: PropTypes.func.isRequired,
    user: PropTypes.string.isRequired,
};
export default ChatMessages;
